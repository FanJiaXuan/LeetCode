#include <iostream>
int m[11] = {0};
int n;
int total = 0;
int is_ok(int row);

void dfs(int row){
    if(row > n){
        total++;
        return;
    }
    for(int col = 1; col <= n; col++){
        m[row] = col;
        if(is_ok(row)){
            dfs(row + 1);
        }
        m[row] = 0;
    }
}

int is_ok(int row){
    for(int i = 1; i != row; i++){
        if(m[i] == m[row] || row - m[row] == i - m[i] || row + m[row] == i + m[i])
            return 0;
    }
    return 1;
}


using namespace std;
int main(){
    cin >> n;
    dfs(1);
    cout << total << endl;
    return 0;
}
