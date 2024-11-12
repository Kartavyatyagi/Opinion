package Controller;

import Model.Comment;
import Model.Database;
import Model.Post;
import View.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadPostCommments {
    private int commentsCounter;
    private ArrayList<Comment> comments;
    public ReadPostCommments(Post p,Database database){
        commentsCounter = 0;
        String select = "SELECT * FROM `comments` WHERE `Post` = "+p.getID()+" ;";
        ArrayList<Integer> usersIDs = new ArrayList<>();
        comments = new ArrayList<>();
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                commentsCounter++;
                Comment c = new Comment();
                c.setID(rs.getInt("ID"));
                c.setContent(rs.getString("Content"));
                usersIDs.add(rs.getInt("User"));
                c.setDateTimeFromString(rs.getString("DateTime"));
                comments.add(c);
            }
            for(int i= 0;i<comments.size();i++ ){
                comments.get(i).setUser(new ReadUserByID(usersIDs.get(i), database).getUser());
            }
        }catch (SQLException e ){
            new Alert(e.getMessage(),null);
        }
    }
    public int getCommentsCount(){
        return commentsCounter;
    }
    public ArrayList<Comment> getComments(){
        return comments;
    }
}
