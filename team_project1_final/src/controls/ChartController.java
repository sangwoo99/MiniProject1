package controls;

import java.util.Map;


import dao.MusicDao;
import vo.Music;

// 장르별 순위 kpop,pop,댄스,발라드   (재생횟수기반)
// 가수별 순위 각 가수의 음악 순위

public class ChartController implements Controller {

	MusicDao musicDao;
	
	public ChartController setMusicDao(MusicDao musicDao) {
		this.musicDao = musicDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Music chartInput = (Music)model.get("chartInput");
		
		model.put("chart", musicDao.selectChart(chartInput));
		return "/chart/Chart.jsp";
		//db에서 가져온것을 다시 jsp에 넣어줘야하니 그냥 경로
		// db가져온거 붙여줄 필요없을땐 redirect:
	}
}
