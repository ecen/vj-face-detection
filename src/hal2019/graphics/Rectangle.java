package hal2019.graphics;

class Rectangle {
    public int x;
    public int y;
    public int w;
    public int h;

    public Rectangle(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "x: "+x+" y: "+y+" w: "+w+" h: "+h;
    }

    public boolean overlaps(Rectangle s){
        return x+w>s.x && x<s.x+s.w && y+h>s.y && y<s.y+s.h;
    }

    public void scale(double s){
        x*=s;
        y*=s;
        w*=s;
        h*=s;
    }
}