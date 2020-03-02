public class DataUtility
	{

	private static PannelloMediaPlayer pannelloMediaPlayer;

	public DataUtility(PannelloMediaPlayer pannelloMediaPlayerPassato)
		{
		pannelloMediaPlayer = pannelloMediaPlayerPassato;
		}

	public static double getAudioBuffersLost()
		{
		return pannelloMediaPlayer.getAudioBuffersLost();
		}

	public static double getPicturesLost()
		{
		return pannelloMediaPlayer.getPicturesLost();
		}

	public static int getDemuxCorrupted()
		{
		return pannelloMediaPlayer.getDemuxCorrupted();
		}

	}
