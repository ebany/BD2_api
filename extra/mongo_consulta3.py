import pymongo

# Función para buscar un juego por nombre y agrupar por plataforma
def buscar_juego_y_agrupar_por_plataforma(nombre_del_juego):
    # Conecta a tu servidor de MongoDB
    client = pymongo.MongoClient('mongodb://user:1234@ac-idgyi4w-shard-00-00.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-01.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-02.ciwruv5.mongodb.net:27017/?replicaSet=atlas-u9kl0f-shard-0&ssl=true&authSource=admin')

    # Selecciona la base de datos y la colección de destino
    db = client['proyecto']
    collection = db['Videojuego']

    # Define el filtro para buscar un juego por nombre
    filtro = {"nombre": {"$regex": f".*{nombre_del_juego}.*", "$options": "i"}}

    # Realiza la búsqueda con el filtro
    resultado_juego = collection.find(filtro)

    # Verifica si se encontró un juego
    juego_encontrado = None
    for juego in resultado_juego:
        juego_encontrado = juego
        break

    if juego_encontrado:
        # Realiza una agregación para agrupar los juegos por plataforma
        pipeline = [
            {"$match": {"nombre": {"$regex": f".*{nombre_del_juego}.*", "$options": "i"}}},
            {"$group": {"_id": "$plataforma", "juegos": {"$push": "$nombre"}}}
        ]
        
        resultado_agregacion = collection.aggregate(pipeline)

        # Imprime la información agrupada por plataforma
        for plataforma in resultado_agregacion:
            print(f"Plataforma: {plataforma['_id']}")
            for juego in plataforma['juegos']:
                print(f"  Juego: {juego}")
    else:
        print(f"No se encontró un juego con el nombre: {nombre_del_juego}")

# Solicita al usuario que ingrese el nombre del juego a buscar
nombre_del_juego = input("Ingresa el nombre del juego a buscar: ")
buscar_juego_y_agrupar_por_plataforma(nombre_del_juego)
