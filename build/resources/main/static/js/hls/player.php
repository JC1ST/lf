<?php
    include_once('./_common.php');
    $_title = '동영상 스트리밍';
    include_once('../../../static/inc/head.html');
    // 스트리밍 동영상들
    $items = array(
	// 샘플 1
	array(
		"title" => "충남조합 에어컨 교육 / 에어컨 시스템의 이해",
		"width" => 900,
		"height" => 504,
		"url" => "http://smo842417-smo842417.ktcdn.co.kr/air_conditioner.mp4/playlist.m3u8"
	),
	// 샘플 2
	array(
		"title" => "충남조합 에어컨 교육 / 증상별 사례 소개",
		"width" => 900,
		"height" => 504,
		"url" => "http://smo842417-smo842417.ktcdn.co.kr/air_conditioner_examples.mp4/playlist.m3u8"
	)
);
?>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="./dist/hls.js?ver=<?=time()?>"></script>
<div id="ctt_con" class="sub01_01">
    <div>
        <video id="video" controls autoplay class="videoCentered" style="border:0px solid #e0e0e0; width: 900px"></video>
        <!-- <table>
            <tr>
                <th>제목</th>
                <th>재생</th>
            </tr>
            <?php
                foreach($items as $item){
            ?>
            <tr>
                <td><?=$item["title"]?></td>
                <td>
                    <button type="button" class="btn btn-xs btn-default playlist" data-url="<?=urlencode($item['url'])?>">재생</button>
                </td>
            </tr>
            <?php
                }
            ?>
        </table> -->

        <?php
            if($play_url == "") {
                $play_url = $items[1]["url"];
            }else{
                $play_url = urldecode($play_url);
            }
         ?>
        <script>

            var video = document.getElementById('video');
            var videoSrc = '<?=$play_url?>';
        	// First check for native browser HLS support
        	if (video.canPlayType('application/vnd.apple.mpegurl')) {
        		video.src = videoSrc;
        	// If no native HLS support, check if hls.js is supported
        	} else if (Hls.isSupported()) {
        		var hls = new Hls();
        		hls.loadSource(videoSrc);
        		hls.attachMedia(video);
        	}

            (function($){

                $(document).ready(function(){

                    $(document).on("click", ".playlist", function(e){
                        // console.log($(this).attr("data-url"));
                        // video.src = $(this).attr("data-url");
                        // video.play();
                        location.href = "/theme/carpos/hls/player.php?play_url=" + $(this).attr("data-url");
                        e.preventDefault();
                    });

                });

            })(jQuery);

        </script>
    </div>
</div>
<?php
    include_once(G5_THEME_PATH.'/tail.php');
?>
