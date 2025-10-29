

class context {
    private strategies s;
    public void setS(strategies st){
        this.s = st;
    }
    public int exec(int a, int b){
        return this.s.execute(a,b);
    }
}

public class strategy{
    strategies s;
    public static void main(String[] args){
        int a = 2, b = 2;
        String s = "+";
        context c = new context();
        if (s.equals("+")){
            c.setS(new addStrategy());
        } else {
            c.setS(new SubStrategy());
        }
        System.out.println(c.exec(a,b));
    }
}

interface strategies {
    public int execute(int a, int b);
}

class addStrategy implements strategies {
    public int execute(int a, int b) {
        return (a+b);
    }
}

class SubStrategy implements strategies {
    public int execute(int a, int b){
        return (a-b);
    }
}