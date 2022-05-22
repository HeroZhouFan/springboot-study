package com.study.springbootstudy.common;

/**
 * redis常量类
 * @author v_merzhang
 * @since 2021/7/5 11:32
 */
public interface RedisConstant {

    /**
     * 场景提取切片步骤锁
     */
    String SCENEEXTRACT_PICK_LOCK = "SCENEEXTRACT_PICK_LOCK";

    /**
     * 真值处理锁
     */
    String POSTPROCESSOR_LOCK = "POSTPROCESSOR_LOCK";

    /**
     * 场景数据切片
     */
    String SCENE_PICK_LOCK = "SCENE_PICK_LOCK";

    /**
     * 扫描回调
     */
    String ADDSESSION_LOCK = "ADDSESSION_LOCK";
    /**
     * 原始数据关联锁
     */
    String ORIGINAL_ASSOCIATION_LOCK = "ORIGINAL_ASSOCIATION_%s_%s";

    /**
     * 数据处理可用服务列表
     * 切片和后处理
     * set结构
     */
    String DATA_PROCESS_SERVICE_AVAILABLE = "DATA_PROCESS_SERVICE_AVAILABLE";

    /**
     * 数据处理已用服务列表
     * 切片和后处理
     * set结构
     */
    String DATA_PROCESS_SERVICE_USED = "DATA_PROCESS_SERVICE_USED";

    /**
     * 评测，场景任务id
     */
    String TASK_KEY = "TASK_KEY%s";

    /**
     * 轨迹数据
     * TRAJECTORY:{数据类型}:{主键}
     * 数据类型： {@link com.tencent.autocloud.roadplatform.enums.DataTypeEnum}
     */
    String TRAJECTORY = "TRAJECTORY:%s:%s";
}
