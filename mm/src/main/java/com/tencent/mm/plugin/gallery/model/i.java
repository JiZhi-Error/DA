package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.GalleryItem;
import java.util.LinkedList;

public interface i {

    public interface a {
        void aL(LinkedList<GalleryItem.AlbumItem> linkedList);
    }

    public interface b {
        void c(LinkedList<GalleryItem.MediaItem> linkedList, long j2);
    }

    public interface c {
        void b(LinkedList<GalleryItem.MediaItem> linkedList, long j2, boolean z);
    }

    LinkedList<GalleryItem.MediaItem> a(String str, int i2, c cVar, long j2);

    LinkedList<GalleryItem.AlbumItem> dQr();

    void dQw();

    void dQx();

    boolean isCancelled();
}
