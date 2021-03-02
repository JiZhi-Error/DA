package com.tencent.luggage.xweb_ext.extendplugin.component;

public interface i {
    <AddOn extends j> AddOn X(Class<AddOn> cls);

    <AddOn extends j> void a(Class<AddOn> cls, AddOn addon);

    String getName();
}
