package database;

/**
 * Created by antonin on 15/05/17.
 */
public abstract class Creator {
    protected long id;

    protected Creator(){
        id = -1;
    }
    protected Creator(long id){
        this.id = id;
    }
}
