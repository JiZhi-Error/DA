package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b&\u0018\u0000 E*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002EFB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\"\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u0002032\b\b\u0002\u00107\u001a\u000208J\u0010\u0010:\u001a\u0002032\b\b\u0002\u00107\u001a\u000208J\b\u0010;\u001a\u00020\u000bH&J\u0015\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010>J5\u0010?\u001a\u0002032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010=\u001a\u00028\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\b\b\u0002\u0010@\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010AJB\u0010B\u001a\u0002032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00028\u00000&j\b\u0012\u0004\u0012\u00028\u0000`'2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010C\u001a\u0002032\u0006\u0010D\u001a\u000208H\u0016R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010%\u001a\u0012\u0012\u0004\u0012\u00028\u00000&j\b\u0012\u0004\u0012\u00028\u0000`'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;)V", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "getHolder", "()Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "setHolder", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "setLoader", "(Lcom/tencent/mm/loader/Loader;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "selectedSet", "Ljava/util/HashSet;", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "animVisible", "", "v", "Landroid/view/View;", "targetVisibility", "isAnim", "", "disableSelected", "enableSelected", "getLayoutId", "isSelectedEnable", "media", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)Z", "onCovert", "covertType", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;Lcom/tencent/mm/loader/Loader;I)V", "onCreateView", "onSelectItem", "isSelected", "Companion", "OnItemMediaSelectedListener", "plugin-gallery_release"})
public abstract class MediaItemView<T extends GalleryItem.MediaItem> extends FrameLayout {
    public static final a xmM = new a((byte) 0);
    public com.tencent.mm.loader.d<T> gVG;
    public ArrayList<T> hXI;
    private b<?> xkD;
    public HashSet<T> xkE;
    public com.tencent.mm.plugin.gallery.picker.a.a xkc;
    public com.tencent.mm.ui.base.a.b xlC;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0001H&¢\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0001H&¢\u0006\u0002\u0010\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", QLog.TAG_REPORTLEVEL_USER, "", "onMediaSelected", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Ljava/lang/Object;)V", "onMediaUnSelected", "plugin-gallery_release"})
    public interface b<E> {
        void a(com.tencent.mm.ui.base.a.b bVar, E e2);

        void b(com.tencent.mm.ui.base.a.b bVar, E e2);
    }

    public abstract int getLayoutId();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaItemView(Context context) {
        super(context);
        p.h(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
    }

    public final b<?> getOnItemMediaSelectedListener() {
        return this.xkD;
    }

    public final void setOnItemMediaSelectedListener(b<?> bVar) {
        this.xkD = bVar;
    }

    public final com.tencent.mm.ui.base.a.b getHolder() {
        com.tencent.mm.ui.base.a.b bVar = this.xlC;
        if (bVar == null) {
            p.btv("holder");
        }
        return bVar;
    }

    public final void setHolder(com.tencent.mm.ui.base.a.b bVar) {
        p.h(bVar, "<set-?>");
        this.xlC = bVar;
    }

    public final HashSet<T> getSelectedSet() {
        HashSet<T> hashSet = this.xkE;
        if (hashSet == null) {
            p.btv("selectedSet");
        }
        return hashSet;
    }

    public final void setSelectedSet(HashSet<T> hashSet) {
        p.h(hashSet, "<set-?>");
        this.xkE = hashSet;
    }

    public final ArrayList<T> getSelectedList() {
        ArrayList<T> arrayList = this.hXI;
        if (arrayList == null) {
            p.btv("selectedList");
        }
        return arrayList;
    }

    public final void setSelectedList(ArrayList<T> arrayList) {
        p.h(arrayList, "<set-?>");
        this.hXI = arrayList;
    }

    public final com.tencent.mm.loader.d<T> getLoader() {
        com.tencent.mm.loader.d<T> dVar = this.gVG;
        if (dVar == null) {
            p.btv("loader");
        }
        return dVar;
    }

    public final void setLoader(com.tencent.mm.loader.d<T> dVar) {
        p.h(dVar, "<set-?>");
        this.gVG = dVar;
    }

    public final com.tencent.mm.plugin.gallery.picker.a.a getAdapter() {
        com.tencent.mm.plugin.gallery.picker.a.a aVar = this.xkc;
        if (aVar == null) {
            p.btv("adapter");
        }
        return aVar;
    }

    public final void setAdapter(com.tencent.mm.plugin.gallery.picker.a.a aVar) {
        p.h(aVar, "<set-?>");
        this.xkc = aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$Companion;", "", "()V", "TAG", "", "plugin-gallery_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
    public static final class e implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ MediaItemView xmO;
        final /* synthetic */ HashSet xmP;
        final /* synthetic */ ArrayList xmQ;
        final /* synthetic */ com.tencent.mm.loader.d xmR;

        public e(MediaItemView mediaItemView, HashSet hashSet, ArrayList arrayList, com.tencent.mm.loader.d dVar) {
            this.xmO = mediaItemView;
            this.xmP = hashSet;
            this.xmQ = arrayList;
            this.xmR = dVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(164951);
            GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) this.xmO.getHolder().hgv();
            if (z != this.xmP.contains(mediaItem)) {
                if (z) {
                    if (this.xmP.add(mediaItem)) {
                        this.xmQ.add(mediaItem);
                    }
                    MediaItemView mediaItemView = this.xmO;
                    com.tencent.mm.ui.base.a.b holder = this.xmO.getHolder();
                    p.g(mediaItem, "media");
                    mediaItemView.a((MediaItemView) holder, (com.tencent.mm.ui.base.a.b) mediaItem, (GalleryItem.MediaItem) this.xmR, (com.tencent.mm.loader.d) 0);
                    b<?> onItemMediaSelectedListener = this.xmO.getOnItemMediaSelectedListener();
                    if (onItemMediaSelectedListener != null) {
                        com.tencent.mm.ui.base.a.b holder2 = this.xmO.getHolder();
                        Object hgv = this.xmO.getHolder().hgv();
                        p.g(hgv, "holder.getAssociatedObject()");
                        onItemMediaSelectedListener.b(holder2, hgv);
                        AppMethodBeat.o(164951);
                        return;
                    }
                    AppMethodBeat.o(164951);
                    return;
                }
                this.xmP.remove(mediaItem);
                this.xmQ.remove(mediaItem);
                MediaItemView mediaItemView2 = this.xmO;
                com.tencent.mm.ui.base.a.b holder3 = this.xmO.getHolder();
                p.g(mediaItem, "media");
                mediaItemView2.a((MediaItemView) holder3, (com.tencent.mm.ui.base.a.b) mediaItem, (GalleryItem.MediaItem) this.xmR, (com.tencent.mm.loader.d) 0);
                b<?> onItemMediaSelectedListener2 = this.xmO.getOnItemMediaSelectedListener();
                if (onItemMediaSelectedListener2 != null) {
                    com.tencent.mm.ui.base.a.b holder4 = this.xmO.getHolder();
                    Object hgv2 = this.xmO.getHolder().hgv();
                    p.g(hgv2, "holder.getAssociatedObject()");
                    onItemMediaSelectedListener2.a(holder4, hgv2);
                    AppMethodBeat.o(164951);
                    return;
                }
            }
            AppMethodBeat.o(164951);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ CheckBox xmS;

        public f(CheckBox checkBox) {
            this.xmS = checkBox;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(164952);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/MediaItemView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            CheckBox checkBox = this.xmS;
            p.g(checkBox, "mediaSelectBox");
            CheckBox checkBox2 = this.xmS;
            p.g(checkBox2, "mediaSelectBox");
            checkBox.setChecked(!checkBox2.isChecked());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/MediaItemView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164952);
        }
    }

    public final void py(boolean z) {
        com.tencent.mm.ui.base.a.b bVar = this.xlC;
        if (bVar == null) {
            p.btv("holder");
        }
        CheckBox checkBox = (CheckBox) bVar.Mn(R.id.fbe);
        p.g(checkBox, "mediaSelectBox");
        if (checkBox.isEnabled()) {
            checkBox.setChecked(z);
        }
    }

    public void a(com.tencent.mm.ui.base.a.b bVar, T t, com.tencent.mm.loader.d<T> dVar, int i2) {
        boolean z;
        boolean z2;
        String str;
        boolean z3 = true;
        p.h(bVar, "holder");
        p.h(t, "media");
        p.h(dVar, "loader");
        this.xlC = bVar;
        bVar.et(t);
        if (i2 == 0 || i2 == 1) {
            CheckBox checkBox = (CheckBox) bVar.Mn(R.id.fbe);
            p.g(checkBox, "mediaSelectBox");
            HashSet<T> hashSet = this.xkE;
            if (hashSet == null) {
                p.btv("selectedSet");
            }
            checkBox.setChecked(hashSet.contains(t));
            checkBox.setSelected(t.getType() == 1 && checkBox.isChecked());
            com.tencent.mm.plugin.gallery.picker.a.a aVar = this.xkc;
            if (aVar == null) {
                p.btv("adapter");
            }
            if (aVar.xkm) {
                ArrayList<T> arrayList = this.hXI;
                if (arrayList == null) {
                    p.btv("selectedList");
                }
                if (arrayList.size() > 0 && checkBox.isChecked() && t.getType() == 1) {
                    ArrayList<T> arrayList2 = this.hXI;
                    if (arrayList2 == null) {
                        p.btv("selectedList");
                    }
                    str = String.valueOf(arrayList2.indexOf(t) + 1);
                    checkBox.setText(str);
                }
            }
            checkBox.setText(str);
        }
        p.h(t, "media");
        HashSet<T> hashSet2 = this.xkE;
        if (hashSet2 == null) {
            p.btv("selectedSet");
        }
        if (hashSet2.size() >= 9) {
            HashSet<T> hashSet3 = this.xkE;
            if (hashSet3 == null) {
                p.btv("selectedSet");
            }
            z = hashSet3.contains(t);
        } else {
            ArrayList<T> arrayList3 = this.hXI;
            if (arrayList3 == null) {
                p.btv("selectedList");
            }
            GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) j.kt(arrayList3);
            if (mediaItem == null) {
                z = true;
            } else if (mediaItem.getType() == 2 && mediaItem.xiZ != t.xiZ && t.getType() != 2) {
                z = false;
            } else if (mediaItem.getType() == 1 && t.getType() == 2) {
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            if (i2 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.tencent.mm.ui.base.a.b bVar2 = this.xlC;
            if (bVar2 == null) {
                p.btv("holder");
            }
            View Mn = bVar2.Mn(R.id.fc0);
            com.tencent.mm.ui.base.a.b bVar3 = this.xlC;
            if (bVar3 == null) {
                p.btv("holder");
            }
            CheckBox checkBox2 = (CheckBox) bVar3.Mn(R.id.fbe);
            com.tencent.mm.ui.base.a.b bVar4 = this.xlC;
            if (bVar4 == null) {
                p.btv("holder");
            }
            View Mn2 = bVar4.Mn(R.id.fbs);
            p.g(checkBox2, "mediaSelectBox");
            c(checkBox2, 0, z2);
            p.g(Mn2, "mediaMaskArea");
            c(Mn2, 4, z2);
            checkBox2.setEnabled(true);
            p.g(Mn, "mediaSelectArea");
            Mn.setEnabled(true);
            return;
        }
        if (i2 != 2) {
            z3 = false;
        }
        com.tencent.mm.ui.base.a.b bVar5 = this.xlC;
        if (bVar5 == null) {
            p.btv("holder");
        }
        View Mn3 = bVar5.Mn(R.id.fc0);
        com.tencent.mm.ui.base.a.b bVar6 = this.xlC;
        if (bVar6 == null) {
            p.btv("holder");
        }
        CheckBox checkBox3 = (CheckBox) bVar6.Mn(R.id.fbe);
        com.tencent.mm.ui.base.a.b bVar7 = this.xlC;
        if (bVar7 == null) {
            p.btv("holder");
        }
        View Mn4 = bVar7.Mn(R.id.fbs);
        p.g(checkBox3, "mediaSelectBox");
        c(checkBox3, 4, z3);
        p.g(Mn4, "mediaGrepArea");
        c(Mn4, 0, z3);
        checkBox3.setSelected(false);
        checkBox3.setChecked(false);
        checkBox3.setEnabled(false);
        p.g(Mn3, "mediaSelectArea");
        Mn3.setEnabled(false);
    }

    private static void c(View view, int i2, boolean z) {
        Log.d("MediaItemView", "[animVisible] isAnim=" + z + " view=" + view.hashCode());
        if (view.getVisibility() != i2) {
            if (!z) {
                view.setVisibility(i2);
                view.setAlpha(1.0f);
                return;
            }
            ViewPropertyAnimator animate = view.animate();
            if (animate != null) {
                animate.cancel();
            }
            view.animate().withStartAction(new c(view, i2)).withEndAction(new d(view, i2)).setDuration(300).alpha((i2 == 4 || i2 == 8) ? 0.0f : 1.0f).start();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ View haw;
        final /* synthetic */ int xmN;

        c(View view, int i2) {
            this.haw = view;
            this.xmN = i2;
        }

        public final void run() {
            AppMethodBeat.i(164949);
            this.haw.setVisibility(0);
            this.haw.setAlpha((this.xmN == 4 || this.xmN == 8) ? 1.0f : 0.0f);
            AppMethodBeat.o(164949);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ View haw;
        final /* synthetic */ int xmN;

        d(View view, int i2) {
            this.haw = view;
            this.xmN = i2;
        }

        public final void run() {
            AppMethodBeat.i(164950);
            this.haw.setVisibility(this.xmN);
            this.haw.setAlpha(1.0f);
            AppMethodBeat.o(164950);
        }
    }
}
