
variable "prefix" {
  default = "vnet"
}

variable "resource_group_name" {
  default = "MyResourceGroup"
}

variable "resource_group_location" {
  default = "East US"
}

variable "hostname" {
  default = "terraform-apache-server"
}

variable "vm_size" {
  default = "Standard_B1ls"
}

variable "admin_username" {
  default = "azureuser"
}

variable "admin_password" {
  default     = "AdminPa55w.rd123"
}

