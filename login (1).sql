use login

CREATE TABLE [Persona] (
  
[idPersona] int Identity(1,1) PRIMARY KEY,
  
[nombre1] varchar(30) NOT NULL,

[nombre2] varchar(30) NOT NULL,
[apellido1] varchar(30) NOT NULL,
[apellido2] varchar(30) NOT NULL,
[identificacion] varchar(10) NOT NULL,
  
[fechaNac] date NOT NULL
  
)

GO

CREATE TABLE [Rol] (
  
[idRol] int Identity(1,1) PRIMARY KEY,
  
[rolNombre] varchar(50) NOT NULL
 
)

GO

CREATE TABLE [RolOpciones] (
  
[idOpcion] int Identity(1,1) PRIMARY KEY,
  
[nombreOpcion] varchar(50) NOT NULL
 
)

GO

CREATE TABLE [RolRolOpciones] (
  
[idRolRolOpcion] int Identity(1,1) PRIMARY KEY,
  
[idRol] int NOT NULL
,
[idOpcion] int NOT NULL

)

GO

CREATE TABLE [RolUsuarios] (
  
[idRolUsuarios] int Identity(1,1) PRIMARY KEY,
  
[idUsuario] int NOT NULL
,
[idRol] int NOT NULL

)

GO

CREATE TABLE [Sesiones] (
  
[idSesion] int Identity(1,1) PRIMARY KEY,
  
[fechaIngreso] date NOT NULL
,
[fechaCierre] date NOT NULL
,
[idUsuario] int NOT NULL
)

GO

CREATE TABLE [Usuarios] (
  
[idUsuario] int Identity(1,1) PRIMARY KEY,
  
[nombreUsuario] varchar(50) NOT NULL
,
[contrasena] varchar(50) NOT NULL
,
[correo] varchar(120) NOT NULL,
[sesionActiva] varchar(1) NOT NULL,
[estado] varchar(20) NOT NULL,
[idPersona] int NOT NULL

)

GO


ALTER TABLE [RolRolOpciones] ADD FOREIGN KEY ([idRol]) REFERENCES [Rol]  ([idRol])

GO


ALTER TABLE [RolRolOpciones] ADD FOREIGN KEY ([idOpcion]) REFERENCES [RolOpciones]  ([idOpcion])

GO


ALTER TABLE [RolUsuarios] ADD FOREIGN KEY ([idUsuario]) REFERENCES [Usuarios]  ([idUsuario])

GO


ALTER TABLE [RolUsuarios] ADD FOREIGN KEY ([idRol]) REFERENCES [Rol]  ([idRol])

GO


ALTER TABLE [Sesiones] ADD FOREIGN KEY ([idUsuario]) REFERENCES [Usuarios]  ([idUsuario])

GO


ALTER TABLE [Usuarios] ADD FOREIGN KEY ([idPersona]) REFERENCES [Persona]  ([idPersona])

GO