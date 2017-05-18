package database;

/**
 * Created by antonin on 15/05/17.
 */
public abstract class Creator {
    protected long id;
    protected boolean idCanChange;
    protected Creator(){
        id = -1;
        idCanChange = true;
    }
    protected Creator(long id){
        this.id = id;
        idCanChange = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if(this.idCanChange)
            this.id = id;
    }
}
