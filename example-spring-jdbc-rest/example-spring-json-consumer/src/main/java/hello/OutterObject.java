package hello;

/**
 * Created by jasonskipper on 10/26/16.
 */
public class OutterObject {
    String type;
    InnerObject value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InnerObject getValue() {
        return value;
    }

    public void setValue(InnerObject value) {
        this.value = value;
    }
}
