package br.edu.fema.bi.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.edu.fema.bi.vo.ViewVO;

@Repository
public class ViewRepository implements RowMapper<ViewVO> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ViewVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		ViewVO view = new ViewVO();
		view.setSchemaName(rs.getString("schemaname"));
		view.setViewName(rs.getString("viewname"));
		view.setDefinition(rs.getString("definition"));
		view.setViewOwner(rs.getString("viewowner"));

		return view;
	}

	public List<ViewVO> findAll() throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from pg_catalog.pg_views");
		sql.append(" where schemaname NOT IN ('pg_catalog', 'information_schema')");
		sql.append(" order by schemaname, viewname;");

		List<ViewVO> views = new ArrayList<ViewVO>();
		
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql.toString());
		
		for (Map<?, ?> map : rows) {
			ViewVO view = new ViewVO();
			view.setSchemaName(String.valueOf(map.get("schemaname")));
			view.setViewName(String.valueOf(map.get("viewname")));
			view.setDefinition(String.valueOf(map.get("definition")));
			view.setViewOwner(String.valueOf(map.get("viewowner")));
			
			view = tratativa(view);
			
			views.add(view);
		}
		
		return views;
	}
	
	public ViewVO findByName(String name) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		ViewVO view = new ViewVO();
		
		sql.append("select * from pg_catalog.pg_views");
		sql.append(" where schemaname NOT IN ('pg_catalog', 'information_schema')");
		sql.append(" and viewname = ?");
		sql.append(" order by schemaname, viewname");
		
		try {
			 view = (ViewVO) jdbcTemplate.queryForObject(sql.toString(),
					new Object[] { name }, new ViewRepository());
			 
			 view = tratativa(view);
			
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return new ViewVO();
		}
		
		return view;
	}
	
	public List<Map<String, Object>> findValuesView(String viewName) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from ");
		sql.append(viewName);
		
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql.toString());
		
		return rows;
	}
	
	private ViewVO tratativa(ViewVO view) {
		if(view != null) {
			view.setDefinition(view.getDefinition().replace("\n", ""));
		}
		return view;
	}

}
