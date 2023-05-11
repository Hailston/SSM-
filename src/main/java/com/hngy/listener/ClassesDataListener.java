package com.hngy.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.hngy.mapper.ClassesMapper;
import com.hngy.mapper.TeacherMapper;
import com.hngy.model.Classes;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @name: ClassesDataListener
 * @author: liuwenxuan
 * @date: 2023-05-11 09:46
 **/
@Slf4j
public class ClassesDataListener implements ReadListener<Classes> {
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<Classes> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private ClassesMapper classesMapper;

    public ClassesDataListener(ClassesMapper classesMapper) {
        this.classesMapper = classesMapper;
    }

    @Override
    public void invoke(Classes data, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        cachedDataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        classesMapper.insertBatch(cachedDataList);
        log.info("存储数据库成功！");
    }
}
