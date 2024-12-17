package aqa_course.ui;

import aqa_course.bo.AppleMusicAlbumBO;
import aqa_course.util.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class AlbumAppleMusicTest {
    @Test
    public void openAlbum() throws InterruptedException {

        AppleMusicAlbumBO appleMusicAlbumBO = new AppleMusicAlbumBO();
        appleMusicAlbumBO.search("skrillex").checkResults();
        appleMusicAlbumBO.openAlbum();
        appleMusicAlbumBO.playAlbumPreview();
    }
}
