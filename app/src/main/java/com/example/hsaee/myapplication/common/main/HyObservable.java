package com.example.hsaee.myapplication.common.main;

/**
 * Created by hj on 2018/9/5.
 */

    public class HyObservable<T> {
        HyOnSubcribe<T> hyOnSubcribe;
        public static <T> HyObservable<T> create(HyOnSubcribe<T> hyOnSubcribe) {
            HyObservable<T> hyObservable = new HyObservable<T>();
            hyObservable.hyOnSubcribe = hyOnSubcribe;
            return hyObservable;
        }
        public void subcribe(final HyObserver<T> observer) {
            hyOnSubcribe.call(observer);
        }
        public static interface HyOnSubcribe<T> {
            void call(HyObserver<T> observer);
        }
        public static interface HyObserver<T> {
            public void onNext(T t);
            public void onComplete();
        }
    }

