package com.bumptech.glide.load.a;

import com.bumptech.glide.g;

public interface d<T> {

    public interface a<T> {
        void S(T t);

        void e(Exception exc);
    }

    void a(g gVar, a<? super T> aVar);

    void cancel();

    void cleanup();

    Class<T> os();

    com.bumptech.glide.load.a ot();
}
