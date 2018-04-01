package cn.linxiuyun.dym.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * mapper继承该类
 *
 */
public interface BaseMapper<T> {
	
	/**
	 * 根据主键id获取
	 */
	public T find(Serializable id);
	
	/**
	 * 保存
	 */
	public int save(T entity);
	
	/**
	 * 更新
	 */
	public int update(T entity);
	/**
	 * 根据主键更新部分属性
	 */
	public int updateParams(T params);
	
	/**
	 * 根据主键id删除
	 */
	public int delete(Serializable id);
	
	/**
	 * 根据条件获取数目
	 */
	public long count(T params);
	
	/**
	 * 根据条件获取一条记录
	 * @param orderBy 排序条件 a asc, b desc ...
	 */
	public T getOne(Map<String, Object> params);
	
	/**
	 * 根据条件获取列表
	 * @param orderBy 排序条件 a asc, b desc ...
	 */
	public List<T> getAll(Map<String, Object> params);
	
	/**
	 * 根据条件分页获取列表
	 * @param fromIndex 分页起始 0, 1, 2 ...
	 * @param pageSize 每页显示记录数
	 * @param orderBy 排序条件 a asc, b desc ...
	 * 
	 */
	public List<T> getScrollData(Map<String, Object> params);
	/**
	 * 根据条件分页获取记录数
	 * @param orderBy 排序条件 a asc, b desc ...
	 */
	public long getScrollCount(Map<String, Object> params);

}
