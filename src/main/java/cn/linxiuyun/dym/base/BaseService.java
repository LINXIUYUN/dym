package cn.linxiuyun.dym.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	
	/**
	 * 根据主键id获取
	 */
	public T find(Serializable id);
	
	/**
	 * 保存
	 */
	public int save(T entity);
	
	/**
	 * 批量保存
	 */
	public void saveBatch(List<T> entities);
	
	/**
	 * 更新
	 */
	public int update(T entity);
	
	/**
	 * 批量更新
	 */
	public void updateBatch(List<T> entities);
	
	/**
	 * 根据主键更新部分属性
	 * @param params 参数（注意Model与数据库对应的字段不要写primitive type）
	 */
	public int updateParams(T params);
	
	/**
	 * 根据主键id删除
	 */
	public int delete(Serializable id);
	
	/**
	 * 根据条件获取数目
	 * @param params 参数（注意Model与数据库对应的字段不要写primitive type）
	 */
	public long count(T params);
	
	/**
	 * 根据条件获取一条记录
	 * @param params 参数（注意Model与数据库对应的字段不要写primitive type）
	 * @param orderBy 排序条件 a asc, b desc ...
	 */
	public T getOne(T params);
	
	/**
	 * 根据条件获取一条记录
	 * @param params 参数（注意Model与数据库对应的字段不要写primitive type）
	 * @param orderBy 排序条件 a asc, b desc ...
	 */
	public T getOne(T params, String orderBy);
	
	/**
	 * 根据条件获取列表
	 * @param params 参数（注意Model与数据库对应的字段不要写primitive type）
	 * @param orderBy 排序条件 a asc, b desc ...
	 */
	public List<T> getAll(T params);
	
	/**
	 * 根据条件获取列表
	 * @param params 参数（注意Model与数据库对应的字段不要写primitive type）
	 * @param orderBy 排序条件 a asc, b desc ...
	 */
	public List<T> getAll(T params, String orderBy);
	
	/**
	 * 根据条件分页获取列表
	 * @param params 参数（注意Model与数据库对应的字段不要写primitive type）
	 * @param orderBy 排序条件 a asc, b desc ...
	 * @param fromIndex 起始位置
	 * @param pageSize 每页显示记录数
	 * 
	 */
	public List<T> getScrollData(T params, String orderBy, int fromIndex, int pageSize);
	
	/**
	 * 根据条件分页获取记录数
	 * @param params 参数（注意Model与数据库对应的字段不要写primitive type）
	 */
	public long getScrollCount(T params);
	
}
