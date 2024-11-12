package Controller;

import Model.Database;
import Model.Post;
import View.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadPostLikes {
    private int likes;
    public ReadPostLikes(Post p , Database database){
        likes = 0;
        String select = "SELECT * FROM `likes` WHERE `Post` = "+p.getID()+" ;";
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                likes++;
            }
        }catch (SQLException e){
            new Alert(e.getMessage(), null);
        }
    }

    public int getLikesCount(){
        return likes;
    }
}
