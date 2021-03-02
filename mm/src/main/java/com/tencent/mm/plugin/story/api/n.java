package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragment;

public interface n {
    AbsStoryGallery a(Context context, a aVar, String str);

    void b(ViewGroup viewGroup, View view, int i2);

    void fP(View view);

    void fQ(View view);

    void fR(View view);

    AbsStoryMuteView hh(Context context);

    AbsStoryHeaderTipView hi(Context context);

    i hj(Context context);

    MMFragment instantiateAlbumFragment(Context context, Bundle bundle);

    Drawable vJ(boolean z);

    public enum a {
        SelfTabGallery,
        SelfGallery,
        ProfileGallery,
        SingleGallery,
        MultiUserGallery,
        HistoryGallery,
        AllFriendGallery,
        FavSelfStoryGallery,
        FavOtherStoryGallery,
        FavSelfStoryGalleryMulti;

        public static a valueOf(String str) {
            AppMethodBeat.i(118418);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(118418);
            return aVar;
        }

        static {
            AppMethodBeat.i(118419);
            AppMethodBeat.o(118419);
        }
    }
}
