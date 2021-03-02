package com.tencent.mm.plugin.story.d;

import com.tencent.mm.plugin.story.i.j;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract;", "", "IFavAlbumPresenter", "IFavAlbumView", "IFavSelectPresenter", "IFavSelectView", "IPresenter", "IView", "plugin-story_release"})
public interface a {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "", "onDestory", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.d.a$a  reason: collision with other inner class name */
    public interface AbstractC1746a {
        void fib();

        void fnw();

        void fnx();

        void fny();

        void onCreate(String str);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "", "onIsAll", "", "isAll", "", "onLoadFavFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "isAllEmpty", "plugin-story_release"})
    public interface b {
        void o(List<j> list, boolean z);

        void vK(boolean z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "", "loadDBData", "", "first", "", "loadFpData", "loadNpData", "onCreate", "userName", "", "onDestory", "setFavorite", "storys", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "plugin-story_release"})
    public interface c {
        void fib();

        void fnw();

        void fnx();

        void hq(List<j> list);

        void onCreate(String str);

        void vL(boolean z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "", "onIsAll", "", "isAll", "", "onLoadFpFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "checkedDatas", "onLoadNpFinish", "plugin-story_release"})
    public interface d {
        void hr(List<j> list);

        void t(List<j> list, List<j> list2);

        void vK(boolean z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "", "checkStoryPost", "", "loadDBData", "loadFpData", "loadNpData", "onCreate", "userName", "", "onDestory", "plugin-story_release"})
    public interface e {
        void fib();

        void fnw();

        void fnx();

        void fnz();

        void onCreate(String str);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "", "onBubbleFail", "", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "plugin-story_release"})
    public interface f {
        void fnA();

        void hh(List<com.tencent.mm.plugin.story.ui.album.c> list);
    }
}
