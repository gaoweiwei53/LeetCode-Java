1) 192 Word Frequency   单词计数
    ```shell
    cat words.txt |tr -s ' ' '\n' |sort|uniq -c|sort -r|awk '{print $2,$1}'
    ```
   1) 首先cat命令查看words.txt
   2) tr -s ' ' '\n'将空格都替换为换行 实现分词
   3) sort排序 将分好的词按照顺序排序
   4) uniq -c 统计重复次数（此步骤与上一步息息相关，-c原理是字符串相同则加一，如果不进行先排序的话将无法统计数目）
   5) sort -r 将数目倒序排列
   6) awk '{print $2,$1}' 将词频和词语调换位置打印出来
    
2) 193 Valid Phone Numbers  输出有效的电话号码
    ```shell
    grep -P '^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$' file.txt
    awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt
    ```
3) 194 Transpose File 转置文件内容
    ```shell
    COUNT=`head -1 file.txt | wc -w`
    for (( i = 1; i <= $COUNT; i++ )); do
    awk -v arg=$i '{print $arg}' file.txt | xargs
    done
    ```
4) 195 Tenth Line 打印第十行
    ```shell
    sed -n '10p' file.txt
    ```
   
    ```
    打印第十行：sed -n '10p' file.txt
    打印一到十行：sed -n '1,10p' file.txt
    查找指定字符：grep -n 'KeyWord' file.txt
    打印指定字符上下5行：grep -C 5 'KeyWord' file.txt
    打印指定字符上下N行：grep -A 100 -B 100 'KeyWord' file.txt
    -A after 后面, -B before 前面
    ```