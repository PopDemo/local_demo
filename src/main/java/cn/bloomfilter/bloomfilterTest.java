package cn.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class bloomfilterTest {


    private static int total = 1000000;
    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total);


    public static void main(String[] args) {

        // 初始化1000000条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put(i);
        }


        for (int i = 0; i < total; i++) {
            if (!bf.mightContain(i)){
                log.info("{},已逃跑了,哎,fuck this",i);
            }
        }

        int count = 0;
        for (int i = total; i < total + 10000; i++) {
            if (bf.mightContain(i)){
                count++;
            }
        }



        log.info("误错的数量为:{}",count);

    }








}
