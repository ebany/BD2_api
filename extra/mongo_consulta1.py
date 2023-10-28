import pymongo

# Conecta a tu servidor de MongoDB
client = pymongo.MongoClient('mongodb://user:1234@ac-idgyi4w-shard-00-00.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-01.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-02.ciwruv5.mongodb.net:27017/?replicaSet=atlas-u9kl0f-shard-0&ssl=true&authSource=admin')

# Selecciona la base de datos y la colección de destino
db = client['proyecto']
collection = db['Videojuego']

# Realiza la consulta para obtener el top 100 de juegos por rating, ordenados en orden descendente
# y proyecta solo los campos que deseas mostrar
top_games = collection.find({}).sort("rating", pymongo.DESCENDING).limit(100)

# Itera sobre los resultados e imprime el nombre, la plataforma, el rating y el género
for juego in top_games:
    print("Nombre:", juego["nombre"])
    print("Plataforma:", juego["plataforma"])
    print("Rating:", juego["rating"])
    print("Género:", juego["genero"])
    print("\n")
