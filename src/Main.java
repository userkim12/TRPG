import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(TRPG_char.status[0]+" TRPG 스타크래프트 시작합니다.");
        System.out.println(TRPG_char.status[0]+" 자신의 유닛 정보를 입력해 주세요.");
        TRPG_char char1 = new TRPG_char();
        TRPG_char char2 = new TRPG_char();
        char1.user_create();
        char1.user_print();
        System.out.println("======================================");
        char2.user_create();
        char2.user_print();
        char1.attack(char1.info_for_attack, char2.info_for_attack);
    }
}

class TRPG_char {
    static String[] status = {"[안내] ", "[시스템] "};
    static String[] information = {"[이름]", "[공격력]", "[방어력]", "[체력]"};
    private String name;
    private String atk;
    private String def;
    private String hp;
    int[] info_for_attack;


    void user_info(String name, String atk, String def, String hp){
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
    }

    void user_create(){
        String[] user = new String[4];
        Scanner sc = new Scanner(System.in);
        System.out.print(status[1] + "유닛 " + information[0] + "을 입력하세요: ");
        user[0] = sc.nextLine();
        System.out.print(status[1] + "유닛 " + information[1] + "을 입력하세요(ex 50): ");
        user[1] = sc.nextLine();
        System.out.print(status[1] + "유닛 " + information[2] + "을 입력하세요(ex 5): ");
        user[2] = sc.nextLine();
        System.out.print(status[1] + "유닛 " + information[3] + "을 입력하세요(ex 100): ");
        user[3] = sc.nextLine();
        user_info(user[0], user[1], user[2], user[3]);

        String[] info_for_pass = new String[3];
        System.arraycopy(user, 1, info_for_pass, 0, 3);
        this.info_for_attack = user_info_int(info_for_pass);
    }

    void user_print(){
        System.out.println('\n' + status[0]+ " 생성된 유닛 정보는 다음과 같습니다.");
        System.out.println(this.name + " 유닛이 게임에 참여했습니다.");
        System.out.println(information[1] + " : "+this.atk);
        System.out.println(information[2] + " : "+this.def);
        System.out.println(information[3] + " : "+this.hp);
    }

    int[] user_info_int(String[] info) {
        int[] info_int = new int[3];
        for(int i=0;i<3;i++){
            info_int[i] = Integer.parseInt(info[i]);
        }
        return info_int;
    }

    void attack(int[] my_info, int[] enemy_info){
        while(true){
            System.out.println("--------------------------------");
            System.out.println(information[0] + " " + this.name+"(이)가 상대 유닛을 공격했습니다!");
            enemy_info[2] -= my_info[0] / enemy_info[1];
            System.out.println(information[0] + " " + "상대 유닛의 남은 체력은 " + enemy_info[2]  + "입니다.");
            if(enemy_info[2] <= 0) break;
            System.out.println("--------------------------------");
        }
        System.out.println("\n" + information[0] + "더 이상 공격할 수 없습니다.");
        System.out.println(information[0] + "상대 유닛 사망");

    }

}
