package sample;

/**
 * Created by Rene on 03/02/2017.
 */
public class Soitjad {

    private String _suund;
    private int _hulk = 0;

    public Soitjad(String suund, int hulk) {
        _suund = suund;
        _hulk = hulk;
    }


    public String getSuund() {
        return _suund;
    }

    public void setSuund(String suund) {
        this._suund = suund;
    }

    public int getHulk() {
        return _hulk;
    }

    public void setHulk(int hulk) {
        this._hulk = hulk;
    }

    public void incrementHulk() {
        setHulk(getHulk() + 1);
    }
}
