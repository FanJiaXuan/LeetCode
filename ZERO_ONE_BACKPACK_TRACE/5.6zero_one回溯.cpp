#include <iostream>
using namespace std;
int n;
double cap;//
double w[101];
double v[101];
double best = 0.0;//bestҪ�и���ֵ
int bestx[101];
double cv = 0.0;
double cw = 0.0;
int x[101] = {0};
int order[101];//order����װ����һ��ʼ�͸�����õı��
//��ֵ����
//���ռ�ֵ��˳�����������

double boarder(int i);

void isort(){//����v�ļ�ֵ����
    double ave[n + 1];
    for(int i = 1; i <= n; i++){
        ave[i] = v[i] / w[i];//����ƽ����ֵ
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
                //��order ���ռ�ֵ����
                //order[i] ����װ�� ��i�Ŷ�Ӧ�ı��
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

    //����Ҫװ�Ĳ��ܳ�������
    if(w[i] + cw <= cap){
        cw += w[i];
        cv += v[i];
        x[i] = 1;
        trace(i + 1);
        x[i] = 0;
        cw -= w[i];
        cv -= v[i];
    }

    //������ڵļ�ֵ ����ʣ�µ� ������������Ҳ С��best �ǿ϶�����
    //����� ���ǲſ�����������
    if(boarder(i + 1) > best){
        trace(i + 1);
    }
}
//����double ����Ŀǰ�ļ�ֵ ���� ʣ�µĶ�����װ�� �����ܲ��ܳ���best
double boarder(int i){
    double p = cv;//cv���ǲ����Ҹĵ� cwҲ���������ĵ�
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
    cout << "��������Ʒ������";
    cin >> n;
    cout << "�����뱳��������";
    cin >> cap;

    cout << "������������Ʒ������";
    for(int i = 1; i <= n; i++){
        cin >> w[i];
        order[i] = i;
    }

    cout << "������������Ʒ��ֵ��";
    for(int i = 1; i <= n; i++){
        cin >> v[i];
    }

    isort();
    trace(1);
    cout << "���Ž��ǣ�";
    cout << best << endl;

    cout << "������Ʒ�ı���ǣ�";

    for(int i = 1; i <= n; i++){
        if(bestx[i])
            cout << order[i] << " ";
    }

    return 0;
}
