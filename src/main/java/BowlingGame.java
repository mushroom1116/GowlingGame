class BowlingGame {
    public int getBowlingScore(String bowlingCode) {
        //二维字符数组
        char[] s = bowlingCode.toCharArray();
        char[][] c = new char[12][2];
        int i=0,j=0;
        for(int cur=0;cur<s.length;cur++)
        {
            if(s[cur] != '|')
            {
                c[i][j] = s[cur];
                j++;
            }
            else
            {
                i++;
                j=0;
            }
        }
        //转换成二维整数数组
        int[][] a = new int[12][2];
        for(int p =0;p<12;p++)
            for(int q=0;q<c[p].length;q++)
            {
               switch (c[p][q]){
                   case 'X':a[p][0]=10;a[p][1]=999;break;
                   case '-':a[p][q]=0;break;
                   case '/':a[p][1]=10-a[p][0];break;
                   case '1':a[p][q]=1;break;
                   case '2':a[p][q]=2;break;
                   case '3':a[p][q]=3;break;
                   case '4':a[p][q]=4;break;
                   case '5':a[p][q]=5;break;
                   case '6':a[p][q]=6;break;
                   case '7':a[p][q]=7;break;
                   case '8':a[p][q]=8;break;
                   case '9':a[p][q]=9;break;
                   default:break;
               }
            }
        //去掉空白行
        int[][] b = new int[11][2];
        for(i=0;i<10;i++)
            for(j=0;j<2;j++)
                b[i][j] = a[i][j];
        b[10][0]=a[11][0];
        b[10][1]=a[11][1];
        //分行处理
        int[] score = new int[10];
        for(i =0;i<9;i++)
        {
            if(b[i][0] == 10 && b[i][1]==999 )
            {
                score[i]=10+b[i+1][0];
                if(a[i+1][1]==999)
                    score[i]=score[i]+b[i+2][0];
                else
                    score[i]=score[i]+b[i+1][1];
            }
            else if(b[i][0]+b[i][1] == 10 )
                score[i]=10+b[i+1][0];
            else
                score[i]=b[i][0]+b[i][1];
        }
        if(b[9][0]==10 && b[9][1]==999)
        {
            if(b[10][0]==10 && b[10][1]==999)
                score[9]=30;
            else
                score[9]=10+b[10][0]+b[10][1];
        }
        else if (b[9][0]+b[9][1]==10)
            score[9]=10+b[10][0];
        else score[9]=b[9][0]+b[9][1];
        //合计
        int w = 0;
        for(i=0;i<10;i++)
            w=w+score[i];
        return w;
        /*int w = 0;
        for(i=0;i<10;i++)
            w=w+score[i];
        return w;*/
    }

}