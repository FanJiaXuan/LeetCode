#include <iostream>
using namespace std;
int n;
double cap;//
double w[101];
double v[101];
double best = 0.0;//best要有个初值
int bestx[101];
double cv = 0.0;
double cw = 0.0;
int x[101] = {0};
int order[101];//order里面装的是一开始就给分配好的编号
//价值排序
//按照价值的顺序遍历二叉树

double boarder(int i);

void isort(){//按照v的价值排序
    double ave[n + 1];
    for(int i = 1; i <= n; i++){
        ave[i] = v[i] / w[i];//计算平均价值
    }
    for(int i = 1; i <= n - 1; i++){
        for(int j = 1; j <= n - i; j++){
            if(ave[j] < ave[j + 1]){
                double temp = ave[j];
                ave[j] = ave[j + 1];
                ave[j + 1] = temp;

                temp = w[j];
                w[j] = w[j + 1];
                w[j + 1] = temp;

                temp = v[j];
                v[j] = v[j + 1];
                v[j + 1] = temp;
                //把order 按照价值排序
                //order[i] 里面装了 第i号对应的编号
                temp =  order[j];
                order[j] = order[j + 1];
                order[j + 1] = temp;
            }
        }
    }
//    for(int i = 1; i <= n; i++){
//        cout << ave[i] << " " <<endl;
//    }
}
//  4 7
//w 3 5 2 1
//v 9 10 7 4
//  3 2 3.5 4
void trace(int i){
    if(i > n){
        if(cv > best){
        best = cv;
        for(int i = 1; i <= n; i++){
            bestx[i] = x[i];
        }
        }
        return;
    }

    //现在要装的不能超过容量
    if(w[i] + cw <= cap){
        cw += w[i];
        cv += v[i];
        x[i] = 1;
        trace(i + 1);
        x[i] = 0;
        cw -= w[i];
        cv -= v[i];
    }

    //如果现在的价值 加上剩下的 就算填满背包也 小于best 那肯定不行
    //如果行 我们才考虑走右子树
    if(boarder(i + 1) > best){
        trace(i + 1);
    }
}
//返回double 就是目前的价值 加上 剩下的都给我装满 看看能不能超过best
double boarder(int i){
    double p = cv;//cv还是不能乱改的 cw也不是能随便改的
    double left = cap - cw;
    while(i <= n && w[i]<= left){
       left -= w[i];
       p += v[i];
       i++;
    }
    if(i <= n ){
        p += (v[i] / w[i]) * left;
       // cw = cap;
    }

    return p;
}
int main(){
    cout << "请输入物品数量：";
    cin >> n;
    cout << "请输入背包容量：";
    cin >> cap;

    cout << "请依次输入物品重量：";
    for(int i = 1; i <= n; i++){
        cin >> w[i];
        order[i] = i;
    }

    cout << "请依次输入物品价值：";
    for(int i = 1; i <= n; i++){
        cin >> v[i];
    }

    isort();
    trace(1);
    cout << "最优解是：";
    cout << best << endl;

    cout << "放入物品的编号是：";

    for(int i = 1; i <= n; i++){
        if(bestx[i])
            cout << order[i] << " ";
    }

    return 0;
}
