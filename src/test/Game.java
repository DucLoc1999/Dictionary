package test;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author SONY
 */
class Player{
    String ten = new String();
    int bd = 0;
    int ViTri = 0;
}
public class Game{
    int[] ThemLuot = {0,0,0};
    int[] OTien = {0,0,0};
    int[] SBT = {0,0,0};
    int[] OLui = {0,0,0};
    int[] SBL = {0,0,0};
    public static int rand(int min , int max) {
            Random rn = new Random();
            int range = max - min + 1;
            int rdnum = min + rn.nextInt(range);
            return rdnum;
    }
    
    public static void VeDiem(Game map, int i, Player ng1, Player ng2, int l)
    {
        int d = 0, c = 0;
        char s[] = {' ','[',' ',']'};
        if(l == 1)
        {
            d = ng1.bd;
            c = ng1.ViTri;
        }
        else
            if(l == 2)
            {
                d = ng2.bd;
                c = ng2.ViTri;
            }
        if((i == 47) && (ng1.ViTri == 47))
        {s[1] = '<';    s[2] = '1';    s[3] = '>';   }
        else
        if((i == 47) && (ng2.ViTri == 47))
        {s[1] = '<';    s[2] = '2';    s[3] = '>';   }
        else
        if((i == ng1.ViTri) && (i== ng2.ViTri))
        {s[1] = '1';    s[2] = '~';    s[3] = '2';   }
        else
        if(i == ng1.ViTri)
        {s[1] = '_';    s[2] = '1';    s[3] = '_';   }
        else
        if(i == ng2.ViTri)
        {s[1] = '_';    s[2] = '2';    s[3] = '_';   }
        else
        if(i == 1)
        {s[1] = '-';    s[2] = '>';    s[3] = '>';   }
        else
        if(i == 47)
        {s[1] = '<';    s[2] = 'X';    s[3] = '>';   }
        else
        for(int j = 0; j < 3; j++)
        {
            if(i == map.OTien[j])
            {
                if ((i > 16) && (i < 32))
                {s[1] = '<';    s[2] = '<';    s[3] = (char)(map.SBT[j]+48);   }
                else
                {s[1] = (char)(map.SBT[j]+48);    s[2] = '>';    s[3] = '>';   }
                break;
            }
            if(i == map.OLui[j])
            {
                if((i > 16) && (i < 32))
                {s[1] = (char)(map.SBL[j]+48);    s[2] = '>';    s[3] = '>';   }
                else
                {s[1] = '<';    s[2] = '<';    s[3] = (char)(map.SBL[j]+48);   }
                break;
            }
            if(i == map.ThemLuot[j])
            {
            s[1] = '?';    s[2] = '#';    s[3] = '?';   
            break;
            }
        }
        if((i == c) && (((d < c) && ((i < 17) || (i > 31))) || ((d > c) && (i > 16) && (i < 32)) ) )
            s[0] = '~';
        if(i == d)
            if(((d > c) && ((i < 17) || (i > 31))) || ((d < c) && ((i > 16) && (i < 32))))
                {s[0] = '~';    s[2] = (s[2] == ' ') ? '.' : s[2];   }
            else
                if((i == d) && (i != 1))
                    s[2] = (s[2] == ' ') ? '.' : s[2];
        
        if((i > d) && (i < c))
            {s[0] = '~';    s[2] = (s[2] == ' ') ? '~' : s[2];    }
        
        String a = new String(s);
        System.out.print(a);
    }
    
    public static void VeMap(Game map, Player ng1, Player ng2, int l)
    {
        for(int i = 1 ;i < 16 ;i++)
            VeDiem(map, i, ng1, ng2, l);
        System.out.print("\n                                                        ");
        VeDiem(map, 16, ng1, ng2, l);
        System.out.println("");
        for(int i = 17 ; i < 32 ; i++)
            VeDiem(map, 48 - i, ng1, ng2, l);
        System.out.println("");
        VeDiem(map, 32, ng1, ng2, l);
        System.out.println("");
        for(int i = 33 ;i < 48 ;i++)
            VeDiem(map, i, ng1, ng2, l);
        System.out.println("");
        //System.out.println(l + "\n###1 " + ng1.bd + " " + ng1.ViTri + "\n###2 " + ng2.bd + " " + ng2.ViTri);
    }
    
    public static void TaoMap(Game map)
    {
        int[] m = new int[9];
        for(int i=0 ; i<9 ; i++)
        {
            int kq = 0;
            m[i] = rand(2,46); 
            while((kq == 0) && (i > 1))
            {
                kq = 1;
                for(int j=0 ; j<i-1 ; j++)
                    {
                        if(m[j] == m[i])
                        {
                            m[i] = rand(2,46);
                            kq = 0;
                        }
                        if(m[j]+1 == m[i])
                        {
                            m[i]++;
                            kq = 0;
                        }
                        if(m[j]-1 == m[i])
                        {
                            m[i]--;
                           kq = 0;
                        }
                        if((m[i] == 1) || (m[i] == 47))
                            m[i] = rand(2,46);
                    }                    
            }
        }
        for(int i=0 ; i<3 ; i++)
        {
            
        map.ThemLuot[i] = m[i];
        //System.out.println(map.ThemLuot[i]);
        map.OLui[i] = m[i+3];
        map.OTien[i] = m[i+6];
        }
        
        for(int i=0 ; i<3 ; i++)
        {
            int kq = 0;
            map.SBT[i] = rand(1,6); 
            while(kq == 0)
            {
                kq = 1;
                for(int j=0 ; j<9 ; j++)
                    {
                        if(map.SBT[i]+map.OTien[i] == m[j])
                        {
                            map.SBT[i] = rand(1,6);
                            kq = 0;
                        }
                    }
            }
        }
        for(int i=0 ; i<3 ; i++)
        {
            int kq = 0;
            map.SBL[i] = rand(1,6); 
            while(kq == 0)
            {
                kq = 1;
                for(int j=0 ; j<9 ; j++)
                    {
                        if(map.SBL[i]-map.OLui[i] == m[j])
                        {
                            map.SBL[i] = rand(1,6);
                            kq = 0;
                        }
                    }
            }
        }
    }
    
    public static void LuotDi(Game map,Player ng1, Player ng2, int l)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        String ten = (l == 1) ? ng1.ten : ng2.ten;
        int buoc = (l == 1) ? ng1.ViTri : ng2.ViTri;
            System.out.print("lượt đi của " + ten + "\nnhập bất kỳ dể dổ xúc xắc.");
            sc.nextLine();
            n = rand(1,6);
            System.out.println(ten + " lắc được " + n + ".\n");
            buoc += n;
            if(l == 1)
                ng1.ViTri = (buoc > 47) ? 47 : buoc;
            else
                ng2.ViTri = (buoc > 47) ? 47 : buoc;
            VeMap(map, ng1, ng2, l);
            for(int i = 0; i < 3; i++)
            {
                if(buoc == map.OTien[i])
                {
                    System.out.println("\n" + ten + " được tiến thêm " + map.SBT[i] + " bước.\n");
                    buoc += map.SBT[i];
                    if(buoc > 47)
                        buoc = 47;
                    if(l == 1)
                        ng1.ViTri = buoc;
                    else
                        ng2.ViTri = buoc;
                    VeMap(map, ng1, ng2, l);
                }
                else
                    if(buoc == map.OLui[i])
                    {
                        System.out.println("\n" + ten + " phải lùi lại " + map.SBL[i] + " bước.\n");
                        buoc -= map.SBL[i];
                        if(buoc < 1)
                            buoc = 1;
                        if(l == 1)
                            ng1.ViTri = buoc;
                        else
                            ng2.ViTri = buoc;
                        VeMap(map, ng1, ng2, l);
                    }
                    else
                        if(buoc == map.ThemLuot[i])
                        {
                            System.out.println("\n" + ten + " được lắc thêm 1 lượt.");
                            if(l == 1)
                                ng1.ViTri = buoc;
                            else
                                ng2.ViTri = buoc;
                            LuotDi(map, ng1, ng2, l);
                            //System.out.println("Theem cho 1" + l);
                        }
            }
        ng1.bd = ng1.ViTri;
        ng2.bd = ng2.ViTri;
        //System.out.println("~~~" + ng1.ViTri + "  " + ng2.ViTri);
    }
    public static void main(String[] args) {
                        //          ~~~tu 1 --> 47~~~
                        //      O--------------------- 15
                        //                           | 1
                        //      ---------------------- 15
                        //      |                      1
                        //      ---------------------X 15
        Scanner sc = new Scanner(System.in);
        Game map = new Game();
        Player ng1 = new Player();
        Player ng2 = new Player();
        int n =1;
        do{
            System.out.println("                           !!!ĐÂY LÀ BẢN ĐỒ LẦN CHƠI NÀY!!!\n");
            TaoMap(map);
            VeMap(map, ng1, ng2, 0);
            System.out.println("\n  ???NẾU BẠN KHÔNG THÍCH HÃY NHẬP 0, NẾU CHẤP NHẬN HÃY NHẬP KÝ TỰ BẤT KỲ???");
            try{
                n = sc.nextInt();
            }catch(Exception e)
            {
                n = 1;
            }
        }while(n == 0);
        System.out.print("HÃY NHẬP TÊN NGƯỜI CHƠI 1: ");
        sc.nextLine(); ng1.ten = sc.nextLine();
        ng1.ViTri = ng1.bd = 1;
        System.out.print("HÃY NHẬP TÊN NGƯỜI CHƠI 2: ");
        ng2.ten = sc.nextLine();
        ng2.ViTri = ng2.bd = 1;
        System.out.println("--------------------------------------------------------------------------------\n                                 ~~~BẮT ĐẦU CHƠI~~~\n");
        map.VeMap(map, ng1, ng2, 0);
        while((ng1.ViTri < 47) && (ng2.ViTri < 47))
        {
            System.out.println("\n--------------------------------------------------------------------------------");
            LuotDi(map, ng1, ng2, 1);
            if(ng1.ViTri < 47)
            {
                System.out.println("\n--------------------------------------------------------------------------------");
                LuotDi(map, ng1, ng2 ,2);
            }
        }
        System.out.print("--------------------------------------------------------------------------------\n                   !!!");
        System.out.println(((ng1.ViTri >= 47) ? ng1.ten : ng2.ten) + " ĐÃ CHIẾN THÁNG!!!");
    }
}