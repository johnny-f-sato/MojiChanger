package jp.co.ysinc.mojichange.domain.entity.tools.spec;


/**
 * Created by ysinc03 on 2016/09/21.
 */
public interface Resource<T> {

    /**
     *
     * @param args argsをもとにリソースを返す
     * @return 任意の型のリソースを返す
     */
    T provideResource();

    /**
     * リソース固有のIDを持つ。SHA256でハッシュ化してもいいかも
     * @return リソース固有のID
     */
    String getUUID();


}
