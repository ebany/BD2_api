import pymongo

# Conecta a tu servidor de MongoDB
client = pymongo.MongoClient('mongodb://user:1234@ac-idgyi4w-shard-00-00.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-01.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-02.ciwruv5.mongodb.net:27017/?replicaSet=atlas-u9kl0f-shard-0&ssl=true&authSource=admin')

# Selecciona la base de datos y la colección de destino
db = client['proyecto']
collection = db['Videojuego']

# Realiza una agregación para obtener el top 100 de juegos que soportan más idiomas
pipeline = [
    {"$unwind": "$language_support"},
    {"$group": {
        "_id": "$_id",
        "nombre": {"$first": "$nombre"},
        "rating": {"$first": "$rating"},
        "idiomas": {"$addToSet": "$language_support"}
    }},
    {"$sort": {"rating": -1, "nombre": 1}},
    {"$limit": 100}
]

resultado_agregacion = list(collection.aggregate(pipeline))

# Imprime el resultado
for juego in resultado_agregacion:
    print("Nombre:", juego["nombre"])
    print("Rating:", juego["rating"])
    print("Idiomas Soportados:", juego["idiomas"])
    print("\n")
