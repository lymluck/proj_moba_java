package entity;

public class ExcCmdInfo {

    /**
     * targetId : 2
     * x : 1056
     * y : 1504
     * targetType : tower
     * id : 5abce380-d647-11e7-866a-37a4ac04a1c4
     * type : attack
     */

    private int targetId;
    private int x;
    private int y;
    private String targetType;
    private String id;
    private String type;

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
