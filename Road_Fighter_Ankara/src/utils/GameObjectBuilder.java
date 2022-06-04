package utils;

import java.util.ArrayList;
import java.util.List;

import interfaces.Collidator;
import interfaces.Collideable;
import interfaces.Renderable;
import interfaces.Updatable;
import javafx.scene.Group;
import objects.AutomovilBot;

public class GameObjectBuilder {
	private static GameObjectBuilder instance = null;
 
	AutomovilBot bot = new AutomovilBot(0, new Punto(0,0));
	
	private Group rootNode = null;

	private List<GameObject> allGameObjects = new ArrayList<GameObject>();
	private List<Updatable> updatables = new ArrayList<Updatable>();
	private List<Renderable> renderables = new ArrayList<Renderable>();
	private List<Collideable> collideables = new ArrayList<Collideable>();
	private List<Collidator> collidators = new ArrayList<Collidator>();

	private Group objectsGroup = new Group();
	private Group collidersGroup = new Group();

	private GameObjectBuilder() {

	}

	public void setRootNode(Group rootNode) {
		if (this.rootNode == null) {
			this.rootNode = rootNode;
			rootNode.getChildren().add(objectsGroup);
	//		rootNode.getChildren().add(collidersGroup);
		} else {
			throw new RuntimeException("Root node already configured");
		}
	}

	public static GameObjectBuilder getInstance() {
		if (instance == null) {
			instance = new GameObjectBuilder();
		}
		return instance;
	}
 
	public void add(GameObject... gameObjects) {
		checkRootNode();

		for (GameObject gameObject : gameObjects) {
			allGameObjects.add(gameObject);

			if (Updatable.class.isAssignableFrom(gameObject.getClass())) {
				updatables.add((Updatable) gameObject);
			}

			if (Renderable.class.isAssignableFrom(gameObject.getClass())) {
				Renderable renderableGameObject = (Renderable) gameObject;
				renderables.add(renderableGameObject);

				objectsGroup.getChildren().add(renderableGameObject.getRender());
			}

			if (Collidator.class.isAssignableFrom(gameObject.getClass())) {
				Collidator collidatorGameObject = (Collidator) gameObject;
				collidators.add(collidatorGameObject);

				collidersGroup.getChildren().add(collidatorGameObject.getCollider());
			} else if (Collideable.class.isAssignableFrom(gameObject.getClass())) {
				Collideable collideableGameObject = (Collideable) gameObject;
				collideables.add(collideableGameObject);

				collidersGroup.getChildren().add(collideableGameObject.getCollider());
			}
		}
	}

	public void remove(GameObject... gameObjects) {
		checkRootNode();

		for (GameObject gameObject : gameObjects) {
			allGameObjects.remove(gameObject);

			if (Updatable.class.isAssignableFrom(gameObject.getClass())) {
				updatables.remove((Updatable) gameObject);
			}

			if (Renderable.class.isAssignableFrom(gameObject.getClass())) {
				Renderable renderableGameObject = (Renderable) gameObject;
				renderables.remove(renderableGameObject);

				objectsGroup.getChildren().remove(renderableGameObject.getRender());
			}

			if (Collidator.class.isAssignableFrom(gameObject.getClass())) {
				Collidator collidatorGameObject = (Collidator) gameObject;
				collidators.remove(collidatorGameObject);

				collidersGroup.getChildren().remove(collidatorGameObject.getCollider());
			} else if (Collideable.class.isAssignableFrom(gameObject.getClass())) {
				Collideable collideableGameObject = (Collideable) gameObject;
				collideables.remove(collideableGameObject);

				collidersGroup.getChildren().remove(collideableGameObject.getCollider());
			}

			gameObject.destroy();
		}
	}

	public List<Updatable> getUpdatables() {
		return new ArrayList<Updatable>(updatables);
	}
	
	public void getBots(boolean b){
		
		AutomovilBot aux;
		
		for(int i=0;i<updatables.size();i++) {
			if(updatables.get(i).getClass().equals(bot.getClass())) {
				aux = (AutomovilBot)updatables.get(i);
				aux.setSpeedUp(b);
			}
		}
		
	}
	
//	public void addBot(AutomovilBot...automovilBots) {
//		for (AutomovilBot bot : automovilBots) {
//			autosBot.add(bot);
//		}
//	}
//
	public List<Collideable> getCollideables() {
		return new ArrayList<Collideable>(collideables);
	}

	public List<Collidator> getCollidators() {
		return new ArrayList<Collidator>(collidators);
	}

	public void removeAll() {
		GameObject[] arrayGameObjects = allGameObjects.toArray(new GameObject[allGameObjects.size()]);
		remove(arrayGameObjects);
		this.rootNode = null;
	}

	private void checkRootNode() {
		if (rootNode == null) {
			throw new RuntimeException("Root node not configured. Please add it first");
		}
	}
	
	

}
