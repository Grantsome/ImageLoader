package com.grantsome.imageloader;

import java.util.List;

/**
 * Created by tom on 2017/3/28.
 */

public class ImageJson {

    /**
     * error : false
     * results : [{"_id":"58d7dd53421aa93abb7d4e5a","createdAt":"2017-03-26T23:25:07.975Z","desc":"3-26","publishedAt":"2017-03-27T11:48:52.828Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-26-17495078_643307445877569_4485136026821459968_n.jpg","used":true,"who":"dmj"},{"_id":"58d49bad421aa93abf5d3b76","createdAt":"2017-03-24T12:08:13.590Z","desc":"3-24","publishedAt":"2017-03-24T12:12:34.753Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-24-17438359_1470934682925012_1066984844010979328_n.jpg","used":true,"who":"dmj"},{"_id":"58d33d54421aa95810795cc1","createdAt":"2017-03-23T11:13:24.719Z","desc":"3-23","publishedAt":"2017-03-23T11:44:38.634Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-23-17265820_645330569008169_4543676027339014144_n.jpg","used":true,"who":"dmj"},{"_id":"58d1e74e421aa90efc4fb70a","createdAt":"2017-03-22T10:54:06.864Z","desc":"3-22","publishedAt":"2017-03-22T11:47:09.555Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-22-17332868_1929305090624552_8918542166154805248_n.jpg","used":true,"who":"dmj"},{"_id":"58d08621421aa95810795ca1","createdAt":"2017-03-21T09:47:13.3Z","desc":"3-21","publishedAt":"2017-03-21T12:19:46.895Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-21-17268102_763630507137257_3620762734536163328_n%20-1-.jpg","used":true,"who":"dmj"},{"_id":"58cf3696421aa90f13178695","createdAt":"2017-03-20T09:55:34.360Z","desc":"3-20","publishedAt":"2017-03-20T11:44:56.224Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-20-17333300_1680707251945881_2009298023053524992_n.jpg","used":true,"who":"daimajia"},{"_id":"58cb5f88421aa95810795c80","createdAt":"2017-03-17T12:01:12.88Z","desc":"3-17","publishedAt":"2017-03-17T12:07:03.767Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-17-17332809_1277469728986540_3201752429582352384_n.jpg","used":true,"who":"dmj"},{"_id":"58c9f47f421aa95810795c73","createdAt":"2017-03-16T10:12:15.342Z","desc":"3-16","publishedAt":"2017-03-16T11:37:02.85Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-16-17333221_108837802984751_2789267558635667456_n.jpg","used":true,"who":"dmj"},{"_id":"58c8adee421aa90f1317866e","createdAt":"2017-03-15T10:58:54.268Z","desc":"3-15","publishedAt":"2017-03-15T11:47:17.825Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-15-17126482_115753765623699_4225645012014071808_n.jpg","used":true,"who":"dmj"},{"_id":"58c72e86421aa90efc4fb6c5","createdAt":"2017-03-14T07:43:02.751Z","desc":"3-14","publishedAt":"2017-03-14T13:17:14.21Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-13-17267506_264626920661300_5781854075880472576_n.jpg","used":true,"who":"带马甲"}]
     */

    private boolean error;

    private List<ResultBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultBean> getResults() {
        return results;
    }

    public void setResults(List<ResultBean> results) {
        this.results = results;
    }

}
