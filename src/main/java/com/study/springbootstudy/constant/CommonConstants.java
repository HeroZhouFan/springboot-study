package com.study.springbootstudy.constant;

import java.io.File;

/**
 * 共用变量constants
 *
 * @author carykaifan
 * @since 2021-09-17
 */
public class CommonConstants {

    //逗号
    public final static String SYMBOL_COMMA = ",";

    //校验数字以逗号分隔字符串正则表达式
    //^[-,0-9]+$
    public final static String REGULAR_INT_COMMA = "\\d+(,\\d+)*";

    //-1
    public final static int NUMBER_NEGATIVE_ONE = -1;

    //-2
    public final static int NUMBER_NEGATIVE_TWO = -2;

    //数字2
    public final static int NUMBER_TWO = 2;
    //数字3
    public final static int NUMBER_THREE = 3;
    //数字4
    public final static int NUMBER_FOUR = 4;
    //数字5
    public final static int NUMBER_FIVE = 5;
    //数字1
    public final static int NUMBER_ONE = 1;

    //数字0
    public final static int NUMBER_ZERO = 0;

    //数字6
    public final static int NUMBER_SIX = 6;

    //数字10
    public final static int NUMBER_TEN = 10;

    //数字三千
    public final static int NUMBER_THREE_THOUSAND = 3000;

    //字符串1
    public final static String STRING_ONE = "1";
    //字符串2
    public final static String STRING_TWO = "2";
    //字符串3
    public final static String STRING_THREE = "3";
    //字符串4
    public final static String STRING_FOUR = "4";
    //字符串10
    public final static String STRING_TEN = "10";
    //字符串0
    public final static String STRING_ZERO = "0";

    //时间格式yyyyMMddHH
    public final static String DATE_FORMATE_HH = "yyyyMMddHH";

    //执行成功
    public final static String TASK_SUCCESS = "SUCCESS :";

    public final static String DEFAULT_USER = "admin";

    public final static String DEFAULT_SCRIPT_TYPE = "python3";

    public final static String DEFAULT_EMPTY_FLAG = "empty";

    public final static String STRING_CSV_FILE_DIR = "csv";

    public final static String STRING_PYTHON_FILE_DIR = "py";
    //过滤.csv扩展名的文件
    public final static String STRING_CSV_FILE_DIR_FILTER=".csv";

    /**
     * 拼接文件名使用的下划线
     */
    public final static String STRING_CSV_FILE_NAME_UNDERLINE = "_";

    public final static String SCENE_ORIGIN_PATH = File.separator + "output" + File.separator + "online";

    /**
     * 运算，冒号字符
     */
    public final static String UNIT_COLON_CHAR = ":";

    /**
     * 运算，均值
     */
    public final static String UNIT_AVERAGE_CHAR = "均值";

    /**
     * 运算，最大值字符
     */
    public final static String UNIT_MAX_VALUE_CHAR = "最大值";

    /**
     * 最小值
     */
    public final static String UNIT_MIN_VALUE_CHAR = "最小值";

    /**
     * 求和
     */
    public final static String UNIT_SUM_CHAR = "求和";

    /**
     * 分号
     */
    public final static String UNIT_SEMICOLON_CHAR = ";";


}
