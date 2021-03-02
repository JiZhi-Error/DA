package com.tencent.xweb.skia_canvas.resource_loader;

public interface IResourceLoader {

    public interface ResourceLoadCallback {
        void onResourceLoaded(byte[] bArr);
    }

    byte[] loadResource(String str, String str2);

    void loadResourceAsync(String str, String str2, ResourceLoadCallback resourceLoadCallback);
}
