package ntu.goalnetdesigner.data.persistence;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable, IDataServiceUnitSubscriber  {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int achievement;

	private int childrenTaskCount;

	private String childTaskID;

	private String className;

	private byte composite;

	private int cost;

	private String description;

	private String name;

	//bi-directional many-to-one association to TaskFunction
	@OneToMany(mappedBy="task")
	private List<TaskFunction> taskFunctions;

	//bi-directional many-to-one association to TasklistTask
	@OneToMany(mappedBy="task")
	private List<TasklistTask> tasklistTasks;

	public Task() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAchievement() {
		return this.achievement;
	}

	public void setAchievement(int achievement) {
		this.achievement = achievement;
	}

	public int getChildrenTaskCount() {
		return this.childrenTaskCount;
	}

	public void setChildrenTaskCount(int childrenTaskCount) {
		this.childrenTaskCount = childrenTaskCount;
	}

	public String getChildTaskID() {
		return this.childTaskID;
	}

	public void setChildTaskID(String childTaskID) {
		this.childTaskID = childTaskID;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public byte getComposite() {
		return this.composite;
	}

	public void setComposite(byte composite) {
		this.composite = composite;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TaskFunction> getTaskFunctions() {
		return this.taskFunctions;
	}

	public void setTaskFunctions(List<TaskFunction> taskFunctions) {
		this.taskFunctions = taskFunctions;
	}

	public TaskFunction addTaskFunction(TaskFunction taskFunction) {
		getTaskFunctions().add(taskFunction);
		taskFunction.setTask(this);

		return taskFunction;
	}

	public TaskFunction removeTaskFunction(TaskFunction taskFunction) {
		getTaskFunctions().remove(taskFunction);
		taskFunction.setTask(null);

		return taskFunction;
	}

	public List<TasklistTask> getTasklistTasks() {
		return this.tasklistTasks;
	}

	public void setTasklistTasks(List<TasklistTask> tasklistTasks) {
		this.tasklistTasks = tasklistTasks;
	}

	public TasklistTask addTasklistTask(TasklistTask tasklistTask) {
		getTasklistTasks().add(tasklistTask);
		tasklistTask.setTask(this);

		return tasklistTask;
	}

	public TasklistTask removeTasklistTask(TasklistTask tasklistTask) {
		getTasklistTasks().remove(tasklistTask);
		tasklistTask.setTask(null);

		return tasklistTask;
	}

}