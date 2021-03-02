package com.bumptech.glide.load.d.d;

import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class a implements j<File, File> {
    /* Return type fixed from 'com.bumptech.glide.load.b.v' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ v<File> a(File file, int i2, int i3, i iVar) {
        AppMethodBeat.i(77466);
        b bVar = new b(file);
        AppMethodBeat.o(77466);
        return bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* bridge */ /* synthetic */ boolean a(File file, i iVar) {
        return true;
    }
}
