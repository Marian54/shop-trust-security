resource "azurerm_network_interface" "vmtf_nic" {
  name                = "${var.prefix}-nic"
  location            = var.resource_group_location
  resource_group_name =  azurerm_resource_group.rg.name
  ip_configuration {
    name                          = "temaip"
    subnet_id                     = azurerm_subnet.subnet.id
    private_ip_address_allocation = "Dynamic"
    public_ip_address_id          = azurerm_public_ip.vmtf_pip.id
  }
}