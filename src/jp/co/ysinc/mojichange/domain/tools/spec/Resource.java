package jp.co.ysinc.mojichange.domain.tools.spec;


/**
 * Created by ysinc03 on 2016/09/21.
 */
public interface Resource<T> {

    /**
     *
     * @param args Sceneを指定する
     * @return Sceneごとの任意の型を返す
     */
    T provideResource(Scene scene);
}
