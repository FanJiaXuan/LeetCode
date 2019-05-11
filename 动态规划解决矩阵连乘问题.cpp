#include <bits/stdc++.h>
using namespace std;
void MatrixChain(int *p , int n, int **m, int ** s){//m����Ҫ����С�������
    for(int i = 1; i <= n; i++)
        m[i][i] = 0;
    for(int r = 2; r <= n; r++){
        for(int i = 1; i <= n - r + 1; i++){
            int j = i + r - 1;
            m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
            s[i][j] = i;
            for(int k = i + 1; k < j; k++){
                int f = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                if(f < m[i][j]){
                    m[i][j] = f;
                    s[i][j] = k;
                }
            }
        }
    }
}

void matrixChain(int *p, int n,int **m, int **s){//Ŀ�������ɾ���m ��¼m��a����b���� �������ʱ����a��b��С�ļ�����,���м�¼�ϵ�ľ���s����Ҫ�����ṩ���Ҿ���r,c������p�����о��������n
    for(int i = 1; i <= n; i++)
        m[i][i] = 0;
    for(int r = 2; r <= n; r++){//а
        cout << "a" <<endl;
        for(int l = 2; l <= n; l++){//��
            int h = l - r + 1;//�� = �� - а + 1
            cout << h << endl;
            m[h][l] = m[h + 1][l] + p[h - 1] * p[h] * p[l];//�ҹ��ɿɵ�
            s[h][l] = h;
            for(int k = h + 1; k < l; k++){
                int temp = m[h][k] + m[k + 1][l] + p[h - 1] * p[k] * p[l];
                if(temp < m[h][l]){
                    m[h][l] = temp;
                    s[h][l] = k;
                }
            }
        }
    }
}

void myTraceBack(int p, int q, int **s){
    if(p == q)
        return;
    myTraceBack(p, s[p][q], s);
    myTraceBack(s[p][q] + 1, q, s);//�ȵ��� �����
    cout << "(" << p << "," << s[p][q] << ")&(" << s[p][q] + 1 << ", " << q << ")" <<endl;
}

void Traceback(int i, int j, int **s){
    if(i == j)
        return;
    Traceback(i, s[i][j], s);
    Traceback(s[i][j] + 1, j ,s);
    cout << "Multply A" << i <<", "<< s[i][j];
    cout <<" and A" <<(s[i][j] + 1) <<", "<< j <<endl;
}
int main(){

    //  һ��Ķ�ά����
    int ** a;
    a = new int *[7];
    for(int i = 0; i < 7; i ++)
    a[i] = new int[7];

   int **s;
   s = new int *[7];
   for(int i = 0; i < 7; i++)
   s[i] = new int[7];

    int n = 6;
    int p[] = {30, 35, 15,5, 10,20,15};
    MatrixChain(p, 6, a, s);
    myTraceBack(1, 6, s);
    return 0;
}
