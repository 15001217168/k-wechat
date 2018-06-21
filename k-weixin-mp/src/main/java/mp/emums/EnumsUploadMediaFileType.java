package mp.emums;

/**
 * @Author:Jrss
 * @Desp:上传媒体文件类型
 * @Date:Create in 15:06 2018/6/20
 * @Modified By:
 */
public enum EnumsUploadMediaFileType {
    /// <summary>
    /// 图片: 128K，支持JPG格式
    /// </summary>
    image,
    /// <summary>
    /// 语音：256K，播放长度不超过60s，支持AMR\MP3格式
    /// </summary>
    voice,
    /// <summary>
    /// 视频：1MB，支持MP4格式
    /// </summary>
    video,
    /// <summary>
    /// thumb：64KB，支持JPG格式
    /// </summary>
    thumb,
    /// <summary>
    /// 图文消息
    /// </summary>
    news
}


