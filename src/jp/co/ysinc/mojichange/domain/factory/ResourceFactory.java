package jp.co.ysinc.mojichange.domain.factory;

import jp.co.ysinc.mojichange.domain.entity.tools.spec.Resource;

/**
 * Created by johnny.f.sato on 2016/08/23.
 */
public interface ResourceFactory<T> {

    Resource<T> create();

}
