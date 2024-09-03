package module2_session06;

public class ex2 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("hi hi ha ha");

        sb.append(" hehe");
        sb.append(" kaka");

        System.out.println(sb);


        String insertStr = String.valueOf(sb.insert(2,"___"));


        System.out.println(insertStr);

        StringBuilder sbReplace = new StringBuilder("Hello w");
        sbReplace.replace(6, 11, "Java");
        System.out.println(sbReplace);


        StringBuilder sbDelete = new StringBuilder("Hello sekai");
        sbDelete.delete(5, 11);
        System.out.println(sbDelete);


        System.out.println(sb.length());

        System.out.println(sb.reverse());

    }
}
