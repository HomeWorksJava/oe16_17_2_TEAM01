/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apitest;


import com.google.gson.Gson;
import com.howtodoinjava.client.upload.FileUploadForm;
import com.mycompany.apitest.model.User;
import com.mycompany.apitest.model.Research;
import com.mycompany.apitest.model.Role;
import com.mycompany.apitest.model.Document;
import com.mycompany.apitest.model.FormData;
import com.mycompany.apitest.model.Title;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;




/**
 * REST Web Service
 *
 * @author Peter
 */
@Path("api")
public class GenericResource {
//private static Map<Integer,User> users=new HashMap<Integer,User>();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @GET    @Path("/getusers")
    @Produces(MediaType.APPLICATION_JSON)
    public String getusersHtml(){
            MyDB db=new MyDB();
            Connection con=db.getCon();
            Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from users");
            ArrayList<User> users=new ArrayList<User>();
            while(res.next()){
                User user=new User();
                
                user.setUsername(res.getString("username"));
                user.setId(res.getInt("id"));
                user.setPasswd("");
                user.setTitulus(res.getString("titulus"));                                
                users.add(user);
            }
            //JsonNode myJsonNode = Json.toJson(MyListObject);
            Gson gson = new Gson();
            return  gson.toJson(users);
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;         
    }
    
     @GET    @Path("/getres")
    //@Produces(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    public String getresearchesHtml(){
            MyDB db=new MyDB();
            Connection con=db.getCon();
            Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from research");
            ArrayList<Research> researches=new ArrayList<Research>();
            while(res.next()){
                Research research=new Research();
                
                research.setResearch_name(res.getString("name"));
                research.setResearch_id(res.getInt("id"));
                research.setFund(res.getInt("money"));
                research.setLeader_id(res.getInt("user_id"));        
                research.setIsPublic(res.getBoolean("public"));                                
                researches.add(research);
            }
            //JsonNode myJsonNode = Json.toJson(MyListObject);
            Gson gson = new Gson();
            return  gson.toJson(researches);
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;         
    }

     @GET    @Path("/getitles")
    //@Produces(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    public String gettitlesHtml(){
            MyDB db=new MyDB();
            Connection con=db.getCon();
            Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from titulusok");
            ArrayList<Title> titles=new ArrayList<Title>();
            while(res.next()){
                Title title=new Title();
                
                title.setTitle_name(res.getString("name"));
                title.setTitle_id(res.getInt("id"));
                titles.add(title);
            }
            //JsonNode myJsonNode = Json.toJson(MyListObject);
            Gson gson = new Gson();
            return  gson.toJson(titles);
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;         
    }
    
    @POST    @Path("/getdocs")
    //@Produces(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({ MediaType.APPLICATION_JSON})
    public String getdocumentsHtml(String userid){
            MyDB db=new MyDB();
            Connection con=db.getCon();
            Statement stmt;
        try {
            
            Gson gson = new Gson();
            User user=gson.fromJson(userid, User.class);
            
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select *,users.username from documents left join users on documents.user_id=users.id where public='1' or documents.user_id='"+user.getId()+"'");
            ArrayList<Document> docs=new ArrayList<Document>();
            while(res.next()){
                Document doc=new Document();
                
                doc.setDoc_name(res.getString("name"));
                doc.setDoc_id(res.getInt("id"));
                doc.setOwner_id(res.getInt("user_id"));
                doc.setIsPublic_doc(res.getBoolean("public"));                                
                doc.setUsername(res.getString("username"));
                docs.add(doc);
            }
            //JsonNode myJsonNode = Json.toJson(MyListObject);

            return  gson.toJson(docs);
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;         
    }
    
      @POST
    @Path("/deletedoc")
    @Consumes("application/json")
    public void deleteDocument(String doc) {
        Gson g = new Gson();
        Document u = g.fromJson(doc, Document.class);
        
          MyDB db=new MyDB();
            Connection con=db.getCon();
            Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.execute("delete from `documents` where id='"+u.getDoc_id()+"'");
            File file = new File("C:/Users/Peter/Documents/NetBeansProjects/apitest_fanniversion/apitest_restful_api_json/apitest/src/main/webapp/resources/files/"+u.getDoc_name());
            file.delete();
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        @GET    @Path("/getroles")
    //@Produces(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    public String getrolesHtml(){
            MyDB db=new MyDB();
            Connection con=db.getCon();
            Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from roles");
            ArrayList<Role> roles=new ArrayList<Role>();
            while(res.next()){
                Role role=new Role();
                
                role.setRole_name(res.getString("name"));
                role.setRole_id(res.getInt("id"));                    
                roles.add(role);
            }
            //JsonNode myJsonNode = Json.toJson(MyListObject);
            Gson gson = new Gson();
            return  gson.toJson(roles);
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;         
    }
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @POST
    @Path("/setres")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void insertResearch(String content){
       Gson gson = new Gson();
       Research res=gson.fromJson(content, Research.class);
           String name=res.getResearch_name();
    
        MyDB db=new MyDB();
        Connection con=db.getCon();
        Statement stmt;
        try {
            stmt = con.createStatement();
            //ResultSet res = stmt.executeQuery("INSERT INTO `users`(`username`, `passwd`, `titulus`) VALUES ('"+u.getUsername()+"','"+u.getPasswd()+"','"+u.getTitulus()+"')");
             stmt.execute("INSERT INTO `research`(`name`, `money`, `user_id`,public) VALUES ('"+res.getResearch_name()+"','"+res.getFund()+"','"+res.getLeader_id()+"','"+(res.isIsPublic()?1:0)+"')");
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
      @POST
    @Path("/modifyres")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void modifyResearch(String content){
       Gson gson = new Gson();
       Research res=gson.fromJson(content, Research.class);
      
         MyDB db=new MyDB();
        Connection con=db.getCon();
        Statement stmt;
        try {
            stmt = con.createStatement();
             stmt.execute("update `research` set `name`='"+res.getResearch_name()+"', `money`='"+res.getFund()+"', `user_id`='"+res.getLeader_id()+"' ,public='"+(res.isIsPublic()?1:0)+"' where id='"+res.getResearch_id()+"'");
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @POST
    @Path("/deleteres")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void deleteResearch(String content){
       Gson gson = new Gson();
       Research res=gson.fromJson(content, Research.class);
       int id=res.getResearch_id();
       
        MyDB db=new MyDB();
        Connection con=db.getCon();
        Statement stmt;
        try {
            stmt = con.createStatement();
             stmt.execute("delete from `research` where id='"+res.getResearch_id()+"'");
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
@POST
	@Path("/upload-file")
	@Consumes("multipart/form-data")
	public Response uploadFile(@MultipartForm FileUploadForm form) {
		String fileName = form.getFileName() == null ? "Unknown" : form.getFileName() ;
		String completeFilePath = "C:/Users/Peter/Documents/NetBeansProjects/apitest_fanniversion/apitest_restful_api_json/apitest/src/main/webapp/resources/files/" + fileName;
		try{
                    
                    //Save the file
                    File file = new File(completeFilePath);
 
                    if (!file.exists()){
                        file.createNewFile();
                    }
	 
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(form.getFileData());
                    fos.flush();
                    fos.close();
                    
                    MyDB db=new MyDB();
                    Connection con=db.getCon();
                    Statement stmt;
                    try {
                        stmt = con.createStatement();
                        stmt.execute("INSERT INTO `documents`(`name`, `user_id`, `public`) VALUES ('"+form.getFileName()+"','"+form.getOwner()+"','"+(form.isIsPublic_doc()=="on"?1:0)+"')");
                    } catch (SQLException ex){
                        Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} 
		catch (IOException e){
			e.printStackTrace();
		}
		//Build a response to return
		return Response.status(200)
		    .entity("uploadFile is called, Uploaded file name : " + fileName).build();
	}
        
    @POST
    @Path("/adduser")
    @Consumes("application/json")
    public void postUser(String user) {
        String response = "New data: " + user;
        
        Gson g = new Gson();
        User u = g.fromJson(user, User.class);
        
          MyDB db=new MyDB();
            Connection con=db.getCon();
            Statement stmt;
        try {
            stmt = con.createStatement();
            //ResultSet res = stmt.executeQuery("INSERT INTO `users`(`username`, `passwd`, `titulus`) VALUES ('"+u.getUsername()+"','"+u.getPasswd()+"','"+u.getTitulus()+"')");
             stmt.execute("INSERT INTO `users`(`username`, `passwd`, `titulus`) VALUES ('"+u.getUsername()+"','"+u.getPasswd()+"','"+u.getTitulus()+"')");
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
    
    @POST
    @Path("/modifyuser")
    @Consumes("application/json")
    public void modifyUser(String user) {
        String response = "Modified: " + user;
        
        Gson g = new Gson();
        User u = g.fromJson(user, User.class);
        
         MyDB db=new MyDB();
            Connection con=db.getCon();
            Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.execute("update `users` set `username`='"+u.getUsername()+"', `titulus`='"+u.getTitulus()+"' where id='"+u.getId()+"'");
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @POST
    @Path("/deleteuser")
    @Consumes("application/json")
    public void deleteUser(String user) {
        String response = "Deleted: " + user;
        
        Gson g = new Gson();
        User u = g.fromJson(user, User.class);
        
          MyDB db=new MyDB();
            Connection con=db.getCon();
            Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.execute("delete from `users` where id='"+u.getId()+"'");
        } catch (SQLException ex){
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}