#include <iostream>
using namespace std;
int item[5];
int mapp[5][9] = { {0} };
int w[] = {0, 2, 3, 4, 5};
int v[] = {0, 3, 4, 5, 6};
/*int** dynamic_prog(int *w, int *v, int n, int capa){
    int **c = new int *[n + 1];
    for(int i = 0; i < n; i++){
        c[i] = new int[capa + 1];
    }

    for(int i = 0; i < capa; i++)
        c[0][i] = 0;
    for(int j = 0; j < n; j++)
        c[j][0] = 0;
    //int c[n + 1][capa + 1] = { {0} };

    for(int i = 1; i<= n; i++){
        for(int j = 1; j <= capa; j++){
            if(w[i] > capa)
                c[i][j] = c[i - 1][j];
            else{
                c[i][j] = max(c[i - 1][j], c[i - 1][j - w[i]] + v[i]);
                //cout << c[i][j] <<endl;
            }
        }
    }
    return c;
}*/

void the_best_solve(int i, int j){//行 列
    if(i <= 0 )
        return;
    if(mapp[i][j] == mapp[i - 1][j]){
        item[i] = 0;
        cout << "不放入" << i << "," << j << endl;
        the_best_solve(i - 1, j);
    }else{
        item[i] = 1;
        cout << "放入" << i << "," << j << endl;
        the_best_solve(i - 1, j - w[i]);
    }
}

int main(){
    int cap = 8;
    //int **c = dynamic_prog(w, v, 4, cap);
   // cout << c[4][8];

    //顺序依次判断每个物品放还是不放 一共就两种情况
    //其实上面这么说也不对
    //外循环i表示 能供选择的物品是前几件
    //mapp记录的是在可以选择前i件物品，容量为j的情况下的最优解
    for(int i = 1; i <= 4; i++){//i对应 不同的物品
        for(int j = 1; j <= cap; j++){
            if(w[i] > j)
                mapp[i][j] = mapp[i - 1][j];
            else{
                mapp[i][j] = max(mapp[i - 1][j], mapp[i - 1][j - w[i]] + v[i]);//选最大的情况放入
            }
        }
    }
    cout << "最优值：" <<mapp[4][8] << endl;;

    the_best_solve(4, 8);

    for(int i = 1; i <= 4; i++){
        cout << item[i] << endl;
    }



    return 0;
}
