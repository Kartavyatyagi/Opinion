package Controller;

import Model.Database;
import Model.User;
import Model.Post;
import View.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadUserPosts {
    private ArrayList<Post> posts;
    public ReadUserPosts(User u, Database database){
        posts = new ArrayList<>();
        String select = "SELECT * FROM `posts` WHERE `User` = "+u.getID()+" ;";
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                Post p = new Post();
                p.setID(rs.getInt("ID"));
                p.setContent(rs.getString("Content"));
                p.setDateTimeFromString(rs.getString("DateTime"));
                p.setUser(u);
                posts.add(p);
            }
        } catch (SQLException e){
            new Alert(e.getMessage(),null);
        }
    }
    public ArrayList<Post> getPosts(){
        return posts;
    }
}
